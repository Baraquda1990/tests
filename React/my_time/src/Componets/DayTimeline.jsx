import '../Styles/DayTimeline.css'
export default function DayTimeline({data,setData,currentDay,currentMonth}){
    let hours=[...Array(24)].map((_,i)=>i)
    let events=[]
    let max_k=0
    if(data!==undefined){
        events = data.map((d,i) => {
            const [h, m] = d.time.split(":")
            return { hour: h, minutes: m, event: d.note, data:d}
        }).filter(d=>d.data.day===currentDay&&d.data.month===currentMonth).sort((a, b) => {
            if (a.hour !== b.hour) return a.hour - b.hour
            return a.minutes - b.minutes
        })
        let kf=0
        for(let i=0;i<events.length;i++){
            if(i===0){events[0].k=kf; continue}
            if(events[i].hour-events[i-1].hour<5){
                kf+=1;if(max_k<kf)max_k=kf;}else{kf=0}
            events[i].k=kf;
        }
    }else{return null}
    if(events.length==0){return null}
    function delData(dlDt){
        const newData = data.filter((d,_) => d !== dlDt);
        setData(newData);
        localStorage.setItem('data', JSON.stringify(newData))
    }
    max_k+=1
    return (<>
        
            <div className="container">
                {hours.map(i=>(
                    <div key={i} className='hour border'>{i}:00</div>
                )
                )}

                <div className="eventsTimeline">
                    {((events.length!==0)&&
                        events.map((d,i)=>(
                        <div key={i} className='eventContainerTimeline' style={{left:`${d.hour*50+(50/60*d.minutes)}px`,paddingTop:`${d.k*120}px`,zIndex:`${max_k-d.k}`}}>
                            <div className="eventTimeline">
                                {d.event}
                                <button onClick={()=>delData(d.data)}>x</button>
                            </div>
                        </div>
                        ))
                    )}
                </div>
            </div>   
    </>)
}