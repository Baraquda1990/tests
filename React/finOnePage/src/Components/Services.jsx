import { Container,Row,Col,Button } from "react-bootstrap"
import styled from "styled-components"
import '../assets/font/font.css'
import icl from "../assets/icon_card_left.png"
import icc from "../assets/icon_card_center.png"
import icr from "../assets/icon_card_right.png"
const ServicesWrapper=styled.div`
  font-family:'OpenSansBold';
  .slogan{
    font-weight:bold;
    color:#4a657d;
  }
  .text{
    color:#4a657d;
  }
  .card_left,.card_center,.card_right{
    padding-top: 8dvh;
    padding-bottom: 10dvh;
    padding-left: 1dvw;
    padding-right: 1dvw;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
  }
  .card_left,.card_right{
    background-color:#edeff2;
    color:#4a657d;
    img{
      width:50px;
    }
    h3{
      font-size:12pt;
    }
    p{
      font-size:10pt;
    }
  }
  .card_center{
    background-color:#1f87e4;
    color:#fff;
    img{
      width:80px;
    }
    h3{
      font-size:15pt;
    }
    p{
      font-size:12pt;
    }
  }
`
export default function Services(){        
        return(<ServicesWrapper><Container>
          <Row>
            <Col className="text-center">
              <h3 className="slogan">{'надежное финансирование для вашего бизнеса'.toUpperCase()}</h3>
              <br />
              <p className="text">
                Компания "Капитал Плюс" поможет Вам в оформлении кредитов на бизнес!
                Наша компания работает по всем сферам кредитования на бизнес цели!
              </p>
            </Col>
          </Row>
        <Row>
          <Col md={4} sm={12} className='text-center mb-5 mt-5 card_left'>
            <img className='mb-3' src={icl} alt="Бизнес-планирование, стратегия и исполнение" />
            <h3 className='mb-3'>{'Бизнес-планирование, стратегия и исполнение'.toUpperCase()}</h3>
            <p className='mb-3'>Мы поможем вам разработать эффективный бизнес-план, выстроить стратегию роста и успешно 
              реализовать каждый этап, чтобы ваш бизнес достиг новых высот.</p>
          </Col>
          <Col md={4} sm={12} className='text-center mb-5 mt-5 card_center'>
            <img className='mb-3' src={icc} alt="финансовые прогнозы и анализ" />
            <h3 className='mb-3'>{'финансовые прогнозы и анализ'.toUpperCase()}</h3>
            <p className='mb-3'>Мы предоставим точные финансовые прогнозы и глубокий анализ, чтобы вы могли принимать 
              обоснованные решения и минимизировать риски на пути к успеху.</p>
          </Col>
          <Col md={4} sm={12} className='text-center mb-5 mt-5 card_right'>
            <img className='mb-3' src={icr} alt="международные деловые возможности" />
            <h3 className='mb-3'>{'международные деловые возможности'.toUpperCase()}</h3>
            <p className='mb-3'>Откройте для себя новые международные деловые возможности и расширьте горизонты 
              вашего бизнеса на глобальной арене.</p>
          </Col>
        </Row>
        </Container></ServicesWrapper>)}