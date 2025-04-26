import { Container,Row,Col } from "react-bootstrap"
import leftImg from '../assets/left_img.jpg'
import styled from "styled-components"
import '../assets/font/font.css'
const StyledWrapper = styled.div`
  .about_img {
    margin-left: -10vw; /* Уходит влево на 10% от ширины окна */
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
  @media (max-width: 1368px) {
    .about_img {
      margin-left: -20vw; /* Уходит дальше влево на маленьких экранах */
    }
  }
  @media (max-width: 1120px) {
    .about_img {
      margin-left: -30vw; /* Уходит дальше влево на маленьких экранах */
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
      margin-left: -50vw; /* Уходит дальше влево на маленьких экранах */
    }
  }
  @media (max-width: 767px) {
    .about_img {
      margin-left: -10vw; /* Уходит дальше влево на маленьких экранах */
      width:90dvw
    }
  }
`

export default function About(){
return(
<StyledWrapper>
<Container fluid className='my-5 about'>
<Row className='align-items-center'>
  <Col md={5} sm={12} xxl={5} className='ps-0'><img src={leftImg} alt="" className="about_img" /></Col>
  <Col md={7} sm={12} xxl={6} className="px-5">
    <h1 className="slogan">{'we are consulting company help you in start'.toUpperCase()}</h1>
    <br/>
    <p className="about_text">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
    sed do eiusmod tempor incididunt ut labore et dolore magna 
    aliqua. Ut enim ad minim veniam, quis nostrud exercitation 
    ullamco laboris nisi ut aliquip ex ea commodo consequat. 
    Duis aute irure dolor in reprehenderit in voluptate velit 
    esse cillum dolore eu fugiat nulla pariatur. Excepteur sint 
    occaecat cupidatat non proident, sunt in culpa qui officia 
    deserunt mollit anim id est laborum. Sed ut perspiciatis unde 
    omnis iste natus error sit voluptatem accusantium doloremque 
    laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore 
    veritatis et quasi architecto beatae vitae dicta sunt explicabo. 
    Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit 
    aut fugit, sed quia consequuntur magni dolores eos qui ratione 
    voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem 
    ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia 
    non numquam eius modi tempora incidunt ut labore et dolore magnam 
    aliquam quaerat voluptatem.
    </p>
  </Col>
</Row>
</Container></StyledWrapper>)}