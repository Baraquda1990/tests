import '../Styles/ButtonDay.css'

export default function ButtonDay({children}){
    return <>
        {children && <button className="day">
            {children}
        </button>}
        
    </>
}