import React, { useState, useEffect } from "react";
import format from "date-fns/format";
import getDay from "date-fns/getDay";
import parse from "date-fns/parse";
import startOfWeek from "date-fns/startOfWeek";
import { Calendar, dateFnsLocalizer } from "react-big-calendar";
import "react-big-calendar/lib/css/react-big-calendar.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { ru } from "date-fns/locale"; // Импорт русской локали для date-fns
import { format as formatDateFns } from 'date-fns'; // Для использования format в кастомной локали
import './App.css';


// Ручная локализация для использования месяцев в родительном падеже
const customRu = {
  ...ru,
  localize: {
    ...ru.localize,
    month: (n) => {
      const months = [
        "январь", "февраль", "март", "апрель", "май", "июнь",
        "июля", "августа", "сентябрь", "октябрь", "ноябрь", "декабрь"
      ];
      return months[n];
    },
    day: (n) => {
      const days = [
        "воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота"
      ];
      return days[n];
    },
  },
};

const localeMap = {
  ru: customRu,
};

const messagesMap = {
  ru: {
    next: "Вперёд",
    previous: "Назад",
    today: "Сегодня",
    month: "Месяц",
    week: "Неделя",
    day: "День",
    agenda: "События",
    date: "Дата",
    time: "Время",
    event: "Событие",
    allDay: "Весь день",
    noEventsInRange: "Нет событий в этом диапазоне.",
    showMore: (total) => `+ ещё ${total}`,
  },
};

function App() {
  const [newEvent, setNewEvent] = useState({ title: "", start: "", end: "" });
  const [allEvents, setAllEvents] = useState([]); // Начинаем с пустого массива событий
  const [currentView, setCurrentView] = useState("week"); // Начальный вид календаря
  const [currentDate, setCurrentDate] = useState(new Date()); // Текущая дата

  // Локализатор для календаря
  const localizer = dateFnsLocalizer({
    format,
    parse,
    startOfWeek,
    getDay,
    locales: localeMap,
  });

  // Загрузка событий из localStorage при старте приложения
  useEffect(() => {
    const savedEvents = localStorage.getItem("events");
    if (savedEvents) {
      const parsedEvents = JSON.parse(savedEvents).map(event => ({
        ...event,
        start: new Date(event.start),
        end: new Date(event.end),
      }));
      setAllEvents(parsedEvents);
    }
  }, []);

  // Сохранение событий в localStorage каждый раз, когда они меняются
  useEffect(() => {
    if (allEvents.length > 0) {
      localStorage.setItem("events", JSON.stringify(allEvents));
    }
  }, [allEvents]);

  // Добавление события
  function handleAddEvent() {
    if (!newEvent.title || !newEvent.start || !newEvent.end) {
      alert("Пожалуйста, заполните все поля.");
      return;
    }

    if (newEvent.end < newEvent.start) {
      alert("Дата окончания не может быть раньше даты начала.");
      return;
    }

    // Добавляем событие в состояние и сохраняем в localStorage
    const updatedEvents = [...allEvents, { ...newEvent, start: new Date(newEvent.start), end: new Date(newEvent.end) }];
    setAllEvents(updatedEvents);
    localStorage.setItem("events", JSON.stringify(updatedEvents));
    setNewEvent({ title: "", start: "", end: "" });
  }

  // Удаление события
  const handleDeleteEvent = (eventToDelete) => {
    const updatedEvents = allEvents.filter(event => event !== eventToDelete);
    setAllEvents(updatedEvents);
    localStorage.setItem("events", JSON.stringify(updatedEvents)); // Сохраняем изменения в localStorage
  };

  // Кастомный рендеринг события с кнопкой "Завершить"
  const CustomEvent = ({ event }) => (
    <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", padding: "5px", border: "1px solid #ddd", borderRadius: "4px" }}>
      <span>{event.title}</span>
      <button
        style={{
          backgroundColor: "#f44336",
          color: "#fff",
          border: "none",
          borderRadius: "4px",
          cursor: "pointer",
          fontSize: "12px",
          padding: "4px 8px",
        }}
        onClick={(e) => {
          e.stopPropagation(); // Чтобы не открылось модальное окно
          handleDeleteEvent(event); // Удалить событие
        }}
      >
        Завершить
      </button>
    </div>
  );

  return (
    <div className="App">
      <h1>Планировщик дел</h1>

      <h2>Добавить событие</h2>
      <div>
        <input
          type="text"
          placeholder="Название"
          style={{ width: "20%", marginRight: "10px" }}
          value={newEvent.title}
          onChange={(e) => setNewEvent({ ...newEvent, title: e.target.value })}
        />
        <DatePicker
          selected={newEvent.start}
          onChange={(start) => setNewEvent({ ...newEvent, start })}
          locale={customRu} 
          dateFormat="Pp"
          showTimeSelect
          timeFormat="HH:mm"
          timeIntervals={15}
          placeholderText="Дата и время начала"
        />
        <DatePicker
          selected={newEvent.end}
          onChange={(end) => setNewEvent({ ...newEvent, end })}
          locale={customRu}  
          dateFormat="Pp"
          showTimeSelect
          timeFormat="HH:mm"
          timeIntervals={15}
          placeholderText="Дата и время окончания"
        />
        <button style={{ marginLeft: "10px" }} onClick={handleAddEvent}>
          Добавить
        </button>
      </div>

      <div style={{ marginTop: "20px" }}>
        <button onClick={() => setCurrentView("month")}>Месяц</button>
        <button onClick={() => setCurrentView("week")}>Неделя</button>
        <button onClick={() => setCurrentView("day")}>Сегодня</button>
        <button onClick={() => setCurrentView("agenda")}>Событии</button>
      </div>

      <Calendar
        localizer={localizer}
        culture="ru"
        events={allEvents}
        startAccessor="start"
        endAccessor="end"
        messages={messagesMap.ru}
        view={currentView}
        views={["month", "week", "day", "agenda"]}
        date={currentDate}
        onNavigate={setCurrentDate}
        style={{ height: 600, margin: "50px" }}
        components={{
          event: CustomEvent, // Используем кастомное отображение событий
        }}
      />
    </div>
  );
}

export default App;