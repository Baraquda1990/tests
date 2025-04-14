import { useState } from 'react'
import '../Styles/Calendar.css'
import '../Styles/ButtonDay.css'
import ButtonDay from './ButtonDay.jsx'
import CaptionMonth from './CaptionMonth.jsx'
import {ButtonLeftSetMonth,ButtonRightSetMonth} from './ButtonSetMonth.jsx'

export default function Calendar({setD,setM}){
    const [month,setMonth]=useState(new Date().getMonth())
    const [daysMonth,setDaysMonth]=useState(getDaysMonth(new Date().getMonth()))
    function changeMonth(right) {
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
    let weeks=tableContents()
    return <>
        <ButtonLeftSetMonth onClick={()=>changeMonth(false)}/>
        <ButtonRightSetMonth onClick={()=>changeMonth(true)}/>
        <table className="calendar">
                <CaptionMonth month={month}/>
            <tbody>
                {
                    weeks.map((week,i)=>(
                        <tr key={i}>
                            {week.map((date,j)=>(
                                (date!==null)
                                ?<td key={date}><button onClick={()=>{setD(date);setM(month);}} className="day">{date}</button></td>
                                :<td key={'n'+j}><ButtonDay></ButtonDay></td>
                                
                            ))}
                        </tr>
                    )   
                )}
            </tbody>
        </table>
    </>
}


