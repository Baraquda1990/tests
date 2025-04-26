import { Container,Row,Col } from "react-bootstrap"
import '../assets/font/font.css'
import rectVideo from '../assets/recl_vid.mp4'
import styled from 'styled-components'
const PartfolioWrapper=styled.section`
  font-family:'OpenSansBold';
  .slogan{
    font-weight:bold;
    color:#4a657d;
  }
  .text,.text_video{
    color:#4a657d;
  }
  .col_video{
    display:flex;
    justify-content: flex-end;
  }
  @media(max-width:768px){
    .col_video,.vid_text{
      display:flex;
      justify-content: center;
    }
  }
  `
export default function Partfolio(){
return(<PartfolioWrapper id="present"><Container className="my-5">
<Row>
  <Col className="text-center">
    <h3 className="slogan">{'Ваш надежный партнер в кредитовании бизнеса: от документации до получения средств'.toUpperCase()}</h3>
    <br/>
    <p className="text">
    Планируете взять кредит у банка на развитие бизнеса? 
    Не хватает времени? Мы нашли для вас решение.
    </p>
  </Col>
</Row>
<Row>
  <Col sm={12} md={6} lg={4} className="col_video">
    <video width="300" controls>
      <source src={rectVideo} type="video/mp4" />
      Ваш браузер не поддерживает видео тег.
    </video></Col>
  <Col sm={12} md={6} lg={8} className="vid_text">
    <p className="text_video"> Мы оказываем консалтинговые услуги 
    в сфере кредитования на развитие бизнеса. Помогаем клиентам в получении кредита 
    как для действующих, так и для начинающих предпринимателей. Мы работаем в данной 
    сфере более шести лет. С нами вы сэкономите свое время. Мы возьмем на себя всю работу, 
    начиная от сбора документов до получения вами денег.
  Почему вы должны доверять именно нам? Наш главный плюс — мы работаем без предоплат, 
  оплату услуг только после выполнения работы. </p></Col>
</Row>
</Container></PartfolioWrapper>)}