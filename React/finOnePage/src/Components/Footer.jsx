import { Container,Row,Col,Button } from "react-bootstrap"
import '../assets/font/font.css'
import styled from 'styled-components'
const FooterWrapper=styled.section`
  font-family:'OpenSansBold';
  background-color:#0e151b;
  color:#fff;
  .contacts_left_col{
    display:flex;
    flex-direction:column;
    justify-content:center;
  }
  @media(max-width:992px){
    .frame{
      width:100dvw;
    }
    .contacts_left_col{
    flex-direction:row;
    justify-content:center;
    font-size:10pt;
  }}
  @media(max-width:620px){
    .contacts_left_col{
      flex-direction:column;
      align-items:center;
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
export default function Footer(){
return(<FooterWrapper id="contacts">
<Container fluid className='pt-5 pb-2' style={{maxWidth:'1920px'}}>
<Row>
  <Col sm={12} lg={{span:2,offset:1}} className="contacts_left_col">
    <h5>Контакты:</h5> 
    <ul style={{marginRight:'10px'}}>
      <li>8 777 928 91 82</li>
      <li>8 771 230 66 68</li>
    </ul>
    <h5>Адрес:</h5>
    <ul>
      <li>г.Актобе, Молдагулова 66/2 , офис 13</li>
      <li>г.Алматы, ул.Гоголя, здание 86</li>
      <li>г.Астана, район Нура, улица Толе-Би, дом 12</li>
    </ul>
    <ContackUs className='btn-info my-1' >СВЯЖИТЕСЬ С НАМИ</ContackUs>
  </Col>
  <Col sm={12} lg={9}>
    <iframe className="frame" src="https://yandex.ru/map-widget/v1/?um=constructor%3Af7fc810d68a467d448512e990f112c9a99cb28925c9fc4660ac906c39c78053e&amp;source=constructor" width="875" height="397"></iframe>
  </Col>
  
</Row>
<Row className='mx-5'><hr className="border border-light" /></Row>
<Row className='text-center'>
  <span>ТОО Капитал плюс 2025</span>
</Row>
</Container>
</FooterWrapper>)}