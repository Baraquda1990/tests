import { useState } from 'react'
import Header from './Components/Header.jsx'
import Slider from './Components/Slider.jsx'
import About from './Components/About.jsx'
import Services from './Components/Services.jsx'
import Practice from './Components/Practice.jsx'
import Jumbotron from './Components/Jumbotron.jsx'
import Partfolio from './Components/Partfolio.jsx'
import Footer from './Components/Footer.jsx'
function App() {
  const [count, setCount] = useState(0)
  return (
    <>
        <Header/>

        <Slider/>

        <About/>
        
        <Services/>

        <Practice/>

        <Jumbotron/>

        <Partfolio/>

        <Footer/>
    </>
  )
}

export default App
