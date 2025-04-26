import { Container,Row,Col } from "react-bootstrap"
import '../assets/font/font.css'
import styled from 'styled-components'
const FooterWrapper=styled.div`
  font-family:'OpenSansBold';
  background-color:#0e151b;
  color:#fff;
`

export default function Footer(){
return(<FooterWrapper>
<Container fluid className='pt-5 pb-2'>
<Row>
  <Col md={{span:2,offset:1}}>
    <p>Contacts: 8 8888 88 88 </p>
  </Col>
  <Col md={9}>wed</Col>
  
</Row>
<Row className='mx-5'><hr className="border border-light" /></Row>
<Row className='text-center'>
  <span>ТОО Капитал плюс 2025</span>
</Row>
</Container>
</FooterWrapper>)}