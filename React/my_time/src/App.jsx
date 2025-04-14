import { useState, useEffect } from 'react'
import './Styles/App.css'
import Calendar from './Componets/Calendar'
import NoteSetter from './Componets/NoteSetter'

export default function App() {
  const [month, setMonth] = useState(0)
  const [day, setDay] = useState(0)
  const [showNote, setShowNote] = useState(false)

  // Показываем NoteSetter только когда меняется выбранный день
  useEffect(() => {
    if (day !== 0) {
      setShowNote(true)
    }
  }, [day, month])

  const handleSaveNote = (note) => {
    console.log("Сохранили заметку:", note)
    setShowNote(false)
  }

  return (
    <>
      <Calendar setD={setDay} setM={setMonth}
      />
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
