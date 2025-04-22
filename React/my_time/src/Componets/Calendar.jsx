import { useState } from 'react'
import '../Styles/Calendar.css'
import '../Styles/ButtonDay.css'
import ButtonDay from './ButtonDay.jsx'
import CaptionMonth from './CaptionMonth.jsx'
import {ButtonLeftSetMonth,ButtonRightSetMonth} from './ButtonSetMonth.jsx'

export default function Calendar({setD,setM,data,setShowNote}){
    const [month,setMonth]=useState(new Date().getMonth())
    const [daysMonth,setDaysMonth]=useState(getDaysMonth(new Date().getMonth()))
    const [selectedDay,setSelectedDay]=useState(0)
    const [countEvents,setCountEvents]=useState(0)
    let changedDays=data.map(d=>({day:d.day,month:d.month}))
    function changeMonth(right) {
        setSelectedDay(0)
        let m=right
            ?(month < 11 ? month + 1 : month)
            :(month > 0 ? month - 1 : month)
        setMonth(m)
        setDaysMonth(getDaysMonth(m))
    }
    function getDaysMonth(m){
        let date=new Date(new Date().getFullYear(),m,1)
        let days=[]
        while (date.getMonth() === m) 
            { days.push({date:date.getDate(),day:date.getDay()})
             date.setDate(date.getDate()+1)}
        return days
    }
    function tableContents(){
        let week=Array(7).fill(null)
        let weeks=[]
        daysMonth.forEach(({date,day})=>{
            week[day]=date
            if(day===6){
                weeks.push(week)
                week=Array(7).fill(null)
            }
        });
        (week.some(d=>d!=null)&&weeks.push(week))
        return weeks
    }
    function setSelectedData(d,m){
        setD(d)
        setM(m)
        setSelectedDay(d)
        let newCountEvents=changedDays.filter(dm=>dm.day===d&&dm.month===m).length
        setCountEvents(newCountEvents)
    }
    let weeks=tableContents()
    return <>
        
        <div className='calendarWrapper'>
        <div className='calendarHeader'>
        <ButtonLeftSetMonth onClick={()=>changeMonth(false)}/>
                <CaptionMonth month={month}/>
        <ButtonRightSetMonth onClick={()=>changeMonth(true)}/>
        </div>
        <table className="calendar">
            <tbody>
                <tr>
                    <td>Воскресенье</td>
                    <td>Понедельник</td>
                    <td>Вторник</td>
                    <td>Среда</td>
                    <td>Четверг</td>
                    <td>Пятница</td>
                    <td>Суббота</td>
                </tr>
                {
                    weeks.map((week,i)=>(
                        <tr key={i}>
                            {week.map((date,j)=>(
                                (date!==null)
                                ?<td key={date} ><button className={`${changedDays.some(d=>d.day===date && d.month === month)? "changed" : ""} ${(selectedDay===date)&&"selected"}`} 
                                                        onClick={()=>{setSelectedData(date,month)}}>{date}<span className='add' onClick={setShowNote}>+</span>
                                                        {countEvents>0&&<span className='countEvents'>{countEvents}</span>}</button></td>
                                :<td key={'n'+j}><ButtonDay></ButtonDay></td>
                                
                            ))}
                        </tr>
                    )   
                )}
            </tbody>
        </table>
        </div>
    </>
}


