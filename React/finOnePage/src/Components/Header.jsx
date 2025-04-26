import { Container,Col,Row,Nav,Navbar,Button } from "react-bootstrap"
import styled from "styled-components"
import '../assets/font/font.css'
import tel from '../assets/tel.png'
import mail from '../assets/mail.jpg'
const StyledNavLink = styled(Nav.Link)`
  color:#4a657d;
  font-size:11pt;
  transition: all 0.3s ease;

  &:hover {background-color: #4a657d;
    color: #ffffff !important;
    cursor: pointer;
  }
`
const ContackUs=styled(Button)`
    &:hover{background-color:#12ab12 !important; color:#fff;}
    border-radius:none;
    border:none;
    color:#fff;
    height:100%;
    @media (max-width: 842px) {
        font-size:9pt;
    }
`
const WrapContainer=styled(Container)`
        background-color:#4a657d;
        font-family:'OpenSansBold';
        color:#fff;
        font-weight: bold;
        img{
            width:20px;
            margin-top:-5px;
        }
        span{
            font-size:12pt;
        }
        @media (max-width: 842px) {
            span{
                font-size:9pt;
            }
            img{
                width:15px;
                margin-top:-3px;
            }
        }
        .wrap_contact_us{
            display:flex;
            justify-content:flex-end;
        }
        @media (max-width: 574px) {
        .wrap_contact_us{
            display:flex;
            justify-content:flex-start;
            }
        }
`
export default function Header(){
    const buttonStyle={

    }
    return(
        <>
        <WrapContainer fluid>
        <Row className='pb-3 pt-3 ps-5 align-items-center'>
        <Col md={8} sm={10}>
            <img className='ms-3'  src={tel}/>
            <span className="mx-3">+7 777 928 91 82</span>
            <span>|</span>
            <img className='ms-3' src={mail}/>
            <span className="mx-3">Kapital.plus86@gmail.com</span>    
        </Col>
        <Col md={4} sm={2} className="wrap_contact_us">
            <ContackUs className='btn-info me-5' >СВЯЖИТЕСЬ С НАМИ</ContackUs>
        </Col>
        </Row>
        </WrapContainer>

        <Container>
        <Row className='pb-3 pt-3 align-items-center'>
            <Col md={2} style={{color:'#4a657d',fontSize:'20pt',fontFamily:'OpenSansBold',lineHeight:'1.5rem'}}>
            ТОО Капитал<br/>плюс</Col>
            <Col md={{span:8,offset:2}} className="d-flex justify-content-end">
            <Navbar bg="light">
                <Nav>
                    <StyledNavLink href="#home" className='px-4'>{'Home'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#features" className='px-4'>{'About Us'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#pricing" className='px-4'>{'Page'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#pricing" className='px-4'>{'Single Page'.toUpperCase()}</StyledNavLink>
                    <StyledNavLink href="#pricing" className='px-4'>{'Contact'.toUpperCase()}</StyledNavLink>
                </Nav>
            </Navbar>
            </Col>            
        </Row>
        </Container>
        </>)}