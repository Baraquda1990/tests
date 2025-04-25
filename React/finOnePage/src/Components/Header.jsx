import { Container,Col,Row,Nav,Navbar,Button } from "react-bootstrap"
import styled from "styled-components"
import '../assets/font/font.css'
import tel from '../assets/tel.png'
import mail from '../assets/mail.jpg'
const StyledNavLink = styled(Nav.Link)`
  transition: all 0.3s ease;

  &:hover {background-color: #4a657d;
    color: #ffffff !important;
    cursor: pointer;
  }
`
const ContackUs=styled(Button)`
    &:hover{background-color:#12ab12 !important;}
`

export default function Header(){
    const color={
        backgroundColor:'#4a657d',
        fontFamily:'OpenSansBold',
        color:'#fff'
    }
    const buttonStyle={
        backgroundColor:'#1f87e3',
        borderRadius:'none',
        border:'none',
        color:'#fff'
    }
    const navStyle={
        color:'#4a657d',
        fontSize:'11pt'
    }
    return(
        <>
        <Container fluid style={color}>
        <Row className='pb-3 pt-3 ps-5 align-items-center'>
        <Col md={6}>
            <img className='ms-3' style={{width:'20px',marginTop:'-5px'}} src={tel}/>
            <span style={{fontSize:'1rem'}} className="mx-3">Call Us: 1 - 587 - 659 - 478</span>
            <span>|</span>
            <img className='ms-3' style={{width:'20px',marginTop:'-5px'}} src={mail}/>
            <span style={{fontSize:'1rem'}} className="mx-3">Mail: examples@company.com</span>    
        </Col>
        
        <Col md={{span:4,offset:2}} style={{display:'flex',justifyContent:"flex-end"}} >
            <ContackUs className='btn-info me-5' style={buttonStyle}>CONTACT WITH US</ContackUs>
        </Col>
        </Row>
        </Container>
        <Container>
        <Row className='pb-3 pt-3 align-items-center'>
            <Col md={2} style={{color:'#4a657d',fontSize:'20pt',fontFamily:'OpenSansBold',lineHeight:'1.5rem'}}>
            ТОО Капитал<br/>плюс</Col>
            <Col md={{span:8,offset:2}} className="d-flex justify-content-end">
            <Navbar bg="light">
                <Nav>
                    <StyledNavLink href="#home" className='px-4' style={navStyle}>{'Home'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#features" className='px-4' style={navStyle}>{'About Us'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#pricing" className='px-4' style={navStyle}>{'Page'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#pricing" className='px-4' style={navStyle}>{'Single Page'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#pricing" className='px-4' style={navStyle}>{'Contact'.toUpperCase()}</StyledNavLink>
                </Nav>
            </Navbar>
            </Col>            
        </Row>
        </Container>
        </>)}