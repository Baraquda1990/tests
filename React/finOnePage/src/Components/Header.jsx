import { Container,Col,Row,Nav,Navbar,Button } from "react-bootstrap"
import '../assets/font/font.css'
import tel from '../assets/tel.png'

export default function Header(){
    const color={
        backgroundColor:'#4a657d',
        fontFamily:'OpenSansBold',
        color:'#fff'
    }
    return(
        <>
        <Container fluid style={color}>
        <Row className='pb-3 pt-3 ps-5 align-items-center'>
        <Col md={3}><img className="px-3" style={{width:'3.5rem'}} src={tel}/><span style={{fontSize:'1dvw'}}>Call Us: 1 - 587 - 659 - 478</span></Col>
        <Col md={{span:3,offset:2}} className='justify-content-end'>f t i g | Support</Col>
        <Col md={2}><Button className='btn-info'>CONTACT WITH US</Button></Col>
        </Row>
        </Container>
        <Container>
        <Row className='pb-3 pt-3 align-items-center'>
            <Col md={2}>Company <br/> consulting</Col>
            <Col md={{span:5,offset:5}}>
            <Navbar bg="light">
                <Nav className="me-auto">
                    <Nav.Link href="#home" className='px-4'>Home</Nav.Link>
                    <Nav.Link href="#features" className='px-4'>About Us</Nav.Link>
                    <Nav.Link href="#pricing" className='px-4'>Page</Nav.Link>
                    <Nav.Link href="#pricing" className='px-4'>Single Page</Nav.Link>
                    <Nav.Link href="#pricing" className='px-4'>Contact</Nav.Link>
                </Nav>
            </Navbar>
            </Col>            
        </Row>
        </Container>
        </>)}