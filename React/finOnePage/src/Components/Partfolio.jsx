import { Container,Row,Col } from "react-bootstrap"
import '../assets/font/font.css'
import rectVideo from '../assets/recl_vid.mp4'
import styled from 'styled-components'
const PartfolioWrapper=styled.div`
  font-family:'OpenSansBold';
  .slogan{
    font-weight:bold;
    color:#4a657d;
  }
  .text,.text_video{
    color:#4a657d;
  }
  @media(max-width:768px){
    .col_video,.vid_text{
      display:flex;
      justify-content: center;
    }
  }
  `
export default function Partfolio(){
return(<PartfolioWrapper><Container className="my-5">
<Row>
  <Col className="text-center">
    <h3 className="slogan">{'our portfolio'.toUpperCase()}</h3>
    <br/>
    <p className="text">
      Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
      sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
    </p>
  </Col>
</Row>
<Row>
  <Col sm={12} md={6} lg={4} className="col_video">
    <video width="300" controls>
      <source src={rectVideo} type="video/mp4" />
      Ваш браузер не поддерживает видео тег.
    </video></Col>
  <Col sm={12} md={6} lg={8} className="vid_text"><p className="text_video">Text Video</p></Col>
</Row>
</Container></PartfolioWrapper>)}