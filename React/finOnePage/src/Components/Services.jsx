import { Container,Row,Col,Button } from "react-bootstrap"
import styled from "styled-components"
import '../assets/font/font.css'
import icl from "../assets/icon_card_left.png"
import icc from "../assets/icon_card_center.png"
import icr from "../assets/icon_card_right.png"
const ServicesWrapper=styled.div`
  font-family:'OpenSansBold';
  .slogan{
    font-weight:bold;
    color:#4a657d;
  }
  .text{
    color:#4a657d;
  }
  .card_left,.card_center,.card_right{
    padding-top: 8dvh;
    padding-bottom: 10dvh;
    padding-left: 1dvw;
    padding-right: 1dvw;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
  }
  .card_left,.card_right{
    background-color:#edeff2;
    color:#4a657d;
    img{
      width:50px;
    }
    h3{
      font-size:12pt;
    }
    p{
      font-size:10pt;
    }
  }
  .card_center{
    background-color:#1f87e4;
    color:#fff;
    img{
      width:80px;
    }
    h3{
      font-size:15pt;
    }
    p{
      font-size:12pt;
    }
  }
`
export default function Services(){        
        return(<ServicesWrapper><Container>
          <Row>
            <Col className="text-center">
              <h3 className="slogan">OUR CONSULTING SERVICES</h3>
              <br />
              <p className="text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
              </p>
            </Col>
          </Row>
        <Row>
          <Col md={4} sm={12} className='text-center mb-5 mt-5 card_left'>
            <img className='mb-3' src={icl} alt="" />
            <h3 className='mb-3'>{'Business planning, strategy & Execution'.toUpperCase()}</h3>
            <p className='mb-3'>Lorem ipsum dolor sit amet, consectetur 
            adipisicing elit, sed doadiadipisicing
            elit, sed do pisicing elit, sed do</p>
          </Col>
          <Col md={4} sm={12} className='text-center mb-5 mt-5 card_center'>
            <img className='mb-3' src={icc} alt="" />
            <h3 className='mb-3'>{'financy projections and analysis'.toUpperCase()}</h3>
            <p className='mb-3'>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
          </Col>
          <Col md={4} sm={12} className='text-center mb-5 mt-5 card_right'>
            <img className='mb-3' src={icr} alt="" />
            <h3 className='mb-3'>{'international business opportunitis'.toUpperCase()}</h3>
            <p className='mb-3'>Lorem ipsum dolor sit amet, consectetur 
            adipisicing elit, sed doadiadipisicing
            elit, sed do pisicing elit, sed do укака</p>
          </Col>
        </Row>
        </Container></ServicesWrapper>)}