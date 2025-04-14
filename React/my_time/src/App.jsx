import { useState, useEffect } from 'react'
import './Styles/App.css'
import Calendar from './Componets/Calendar'
import NoteSetter from './Componets/NoteSetter'
import Events from './Componets/Events'

export default function App() {
  const [month, setMonth] = useState(0)
  const [day, setDay] = useState(0)
  const [showNote, setShowNote] = useState(false)
  const [data,setData]=useState([])

  useEffect(() => {
    const savedData = localStorage.getItem('data')
    if (savedData) {
      setData(JSON.parse(savedData))
    }
  }, [])

  useEffect(() => {
    if (day !== 0) {
      setShowNote(true)
    }
  }, [day, month])

  const handleSaveNote = (note) => {
    //console.log("Сохранили заметку:", note)
    setShowNote(false)
    const newData = [...(data || []), note]
    setData(newData)
    localStorage.setItem('data', JSON.stringify(newData))
  }

  return (
    <>
      <Calendar setD={setDay} setM={setMonth} data={data}/>
      <Events data={data} setData={setData}/>
      <NoteSetter 
        isOpen={showNote} 
        day={day} 
        month={month} 
        onSave={handleSaveNote} 
        onClose={() => setShowNote(false)} 
      />
    </>
  )
}
