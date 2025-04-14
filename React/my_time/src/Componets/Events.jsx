
export default function Events(props){
    if(props.data.length===0){
        return null
    }
    function delData(i){
        const newData = props.data.filter((_, index) => index !== i);
        props.setData(newData);
        localStorage.setItem('data', JSON.stringify(newData))
    }
    return(
    <table>
        <thead>
            <tr>
                <th>День</th>
                <th>Месяц</th>
                <th>Время</th>
                <th>Событие</th>
            </tr>
        </thead>
        <tbody>
    {props.data.map((d,i)=>
        <tr key={i}>
            <td key={10+i}>{d.day}</td>
            <td key={20+i}>{d.month}</td>
            <td key={30+i}>{d.time}</td>
            <td key={40+i}>{d.note}</td>
            <td><button onClick={()=>delData(i)}>Удалить</button></td>
        </tr>)}
        </tbody>
    </table>)
}