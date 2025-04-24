import { Container,Row,Col } from "react-bootstrap"
export default function Footer(){

return(
<Container fluid className='pt-5 pb-2'>
<Row>
  <Col className='md-2 offset-1'>
    <p>Contacts: 8 8888 88 88 </p>
  </Col>
  <Col className='md-9'>wed</Col>
  
</Row>
<Row className='mx-5'><hr className="border border-light" /></Row>
<Row className='text-center'>
  <span>Cyberdine Systems 2025</span>
</Row>
</Container>)}