import { useState } from 'react';
import '../Styles/NoteSetterModal.css'; // стили ниже 👇

let monthNames={
  0:'Января',
  1:'Февраля',
  2:'Марта',
  3:'Апреля',
  4:'Мая',
  5:'Июня',
  6:'Июля',
  7:'Августа',
  8:'Сентября',
  9:'Октября',
  10:'Ноября',
  11:'Декабря'
}

export default function NoteSetterModal({ isOpen, day, month, onClose, onSave }) {
  const [time, setTime] = useState('');
  const [note, setNote] = useState('');

  if (!isOpen) return null;

  const handleSave = () => {
    if (!time || !note) return alert("Введите время и заметку!");
    
    onSave({ day, month, time, note });
    setNote('');
    setTime('');
    onClose();
  };

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h3>Заметка на {day} {monthNames[month]}</h3>
        <input 
          type="time" 
          value={time} 
          onChange={(e) => setTime(e.target.value)} 
        />
        <input 
          type="text" 
          placeholder="Введите заметку..." 
          value={note} 
          onChange={(e) => setNote(e.target.value)} 
        />
        <div className="modal-buttons">
          <button onClick={handleSave}>Сохранить</button>
          <button onClick={onClose}>Отмена</button>
        </div>
      </div>
    </div>
  );
}