import { Container,Row,Col,Button } from "react-bootstrap"
import leftImg from '../assets/left_img.jpg'
import styled from "styled-components"
import '../assets/font/font.css'
const StyledWrapper = styled.section`
  .about_img {
    transition: margin-left 0.3s ease;
  }
  .slogan{
    font-weight:bold;
    font-family:'OpenSansBold';
    color:#4a657d;
    font-size:25pt;
  }
  .about_text{
    font-family:'OpenSansBold';
    color:#4a657d;
    font-size:15pt;
  }
  @media (max-width: 1120px) {
    .about_img {
      margin-left: -30vw; 
    }
    .slogan{
      font-size:20pt;
    }
    .about_text{
      font-size:10pt;
    }
  }
  @media (max-width: 954px) {
    .about_img {
      margin-left: -50vw; 
    }
  }
  @media (max-width: 767px) {
    .about_img {
      margin-left: -10vw; 
      width:90dvw
    }
  }
  @media (min-width: 1184px) {
    .about_img {
      margin-left:-20dvw; 
    }
  }
  @media (min-width: 1280px) {
    .about_img {
      margin-left:-10dvw; 
    }
  }
  @media (min-width: 1920px) {
    .about_img {
      margin-left:-5dvw; 
    }
  }
`
const ContackUs=styled(Button)`
    &:hover{background-color:#12ab12 !important; color:#fff;}
    border-radius:none;
    border:none;
    color:#fff;
    @media (max-width: 842px) {
        font-size:9pt;
    }
`
export default function About(){
return(
<StyledWrapper id='about'>
<Container fluid className='my-5 about' style={{maxWidth:'1536px'}}>
<Row className='align-items-center'>
  <Col md={5} sm={12} className='img_container'><img src={leftImg} alt="Получите кредит для бизнеса без лишних сложностей" className="about_img" /></Col>
  <Col md={7} sm={12} className="px-5">
    <h1 className="slogan">{'Получите кредит для бизнеса без лишних сложностей!'.toUpperCase()}</h1>
    <br/>
    <p className="about_text">
    Если вам нужно финансирование от 50 миллионов тенге, но вы не хотите разбираться с 
    документами и нюансами оформления — мы поможем! Мы с 6-летним опытом работы в сфере 
    кредитования возьмём на себя всю работу: подготовим документы, оформим заявку, упакуем 
    ваш проект и будем сопровождать на каждом этапе до получения средств.
    Мы помогаем получить кредиты на развитие бизнеса, инвестиции, участие в тендерах и 
    финансирование через госпрограммы. У нас прозрачная работа без предоплаты.</p>
    <p className="about_text">Что мы вам гарантируем:</p>
    <ul className="about_text">
      <li>Грамотно оформленные документы и бизнес-план.</li>
      <li>Подбор лучших условий и минимизация рисков.</li>
      <li>Полное сопровождение до получения средств.</li>
    </ul>
    <p className="about_text">Если у вас хорошая кредитная история, стабильная прибыль и залог — запишитесь на 
    бесплатную консультацию. Мы разберём ваш проект и предложим оптимальные условия.
    </p>
    <ContackUs className='btn-info me-5' >СВЯЖИТЕСЬ С НАМИ</ContackUs>
  </Col>
</Row>
</Container></StyledWrapper>)}