import { Carousel } from "react-bootstrap"
import slide01 from '../assets/slide_01.jpg'
import slide02 from '../assets/slide_02.jpg'
import slide03 from '../assets/slide_03.jpg'
import slide04 from '../assets/slide_04.jpg'
import styled from "styled-components"
import '../assets/font/font.css'
const StyledCarousel=styled(Carousel)`
  font-family:'OpenSansBold';
  .carousel-indicators{
    button{width:20px;
      height:20px;
      border-radius:50%;
      background-color:#1f87e4 !important;
    }
  }
  .carousel-caption{
    background: linear-gradient(
    to right,
    rgba(255, 255, 255, 0) 0%,  
    rgba(255, 255, 255, 1) 20%, 
    rgba(255, 255, 255, 1) 80%,  
    rgba(255, 255, 255, 0) 100%  
  );
  }
  h5{
    color:#4a657d;
    font-weight: bold;
    font-size:30pt;
  }
  p{
    font-size:15pt;
  }
  @media(max-width:630px){
      h5{
        font-size:15pt;
      }
      p{
        font-size:12px;
      }
  }

`

export default function Slider(){
return(
<StyledCarousel data-bs-theme="dark">
<Carousel.Item>
  <img
    className="d-block w-100"
    src={slide01}
    alt="Залоговые кредиты"
  />
  <Carousel.Caption>
    <h5>{'Залоговые кредиты'.toUpperCase()}</h5>
    <p>Залоговые кредиты на бизнес цели (пополнение оборотных средств, инвестиции).</p>
  </Carousel.Caption>
</Carousel.Item>
<Carousel.Item>
  <img
    className="d-block w-100"
    src={slide02}
    alt="Рефинансирование залоговых кредитов"
  />
  <Carousel.Caption>
    <h5>{'Рефинансирование залоговых кредитов'.toUpperCase()}</h5>
    <p>Рефинансирование залоговых кредитов ранее полученных на бизнес цели.</p>
  </Carousel.Caption>
</Carousel.Item>
<Carousel.Item>
  <img
    className="d-block w-100"
    src={slide03}
    alt="Авто кредитование"
  />
  <Carousel.Caption>
    <h5>{'Авто кредитование'.toUpperCase()}</h5>
    <p>Авто кредитование (кредиты для покупки спецтехники и грузового автотранспорта).</p>
  </Carousel.Caption>
</Carousel.Item>
<Carousel.Item>
  <img
    className="d-block w-100"
    src={slide04}
    alt="Бизнес ипотека"
  />
  <Carousel.Caption>
    <h5>{'Бизнес ипотека'.toUpperCase()}</h5>
    <p>Бизнес ипотека (приобретение коммерческих объектов недвижимости).</p>
  </Carousel.Caption>
</Carousel.Item>
</StyledCarousel>)}