    import '../Styles/Events.css'
    export default function Events(props){
    let currentDM=props.data.filter(d=>(d.day===props.currentDay)&&(d.month===props.currentMonth))
    if(currentDM.length==0){
        return null
    }
    function delData(dlDt){
        const newData = props.data.filter((d,_) => d !== dlDt);
        props.setData(newData);
        localStorage.setItem('data', JSON.stringify(newData))
    }
    return(
    <table className="events">
        <thead>
            <tr>
                <th>День</th>
                <th>Месяц</th>
                <th>Время</th>
                <th>Событие</th>
            </tr>
        </thead>
        <tbody>
    {currentDM.map((d,i)=>
        <tr key={i}>
            <td key={10+i}>{d.day}</td>
            <td key={20+i}>{d.month}</td>
            <td key={30+i}>{d.time}</td>
            <td key={40+i}>{d.note}</td>
            <td><button onClick={()=>delData(d)}>Удалить</button></td>
        </tr>)}
        </tbody>
    </table>)
}