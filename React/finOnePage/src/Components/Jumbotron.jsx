import React from 'react';
import { Container,Row,Col } from 'react-bootstrap';
import { Parallax } from 'react-parallax';
import img from '../assets/bg_jumbotron.jpg'
import '../assets/font/font.css'
import styled from 'styled-components'
const ParallaxStyled=styled(Parallax)`
  font-family:'OpenSansBold';
  h3{
    font-weight:bold;
  }
`
const Jumbotron = () => {
  return (
    <ParallaxStyled bgImage={img} strength={200}>
        <Container className='my-5 pt-5'>
        <Row>
            <Col className="text-center text-light">
              <h3>{'почему выбирают нас'.toUpperCase()}</h3>
              <br />
              <p>
              Нас выбирают за опыт, профессионализм и индивидуальный подход: мы предлагаем оптимальные решения, 
              минимизируем риски и обеспечиваем полный цикл поддержки на пути к вашему бизнес-успеху.
              </p>
            </Col>
          </Row>
          <Row className='text-center text-light my-5 pb-5'>
            <Col>
              <h1>2300</h1>
              <p>{'инвестиционное планирование'.toUpperCase()}</p>
            </Col>
            <Col>
              <h1>3250</h1>
              <p>{'торговля сырьевыми товарами'.toUpperCase()}</p>
            </Col>
            <Col>
              <h1>4571</h1>
              <p>{'управление активами'.toUpperCase()}</p>
            </Col>
            <Col>
              <h1>5475</h1>
              <p>{'счастливые клиенты'.toUpperCase()}</p>
            </Col>
          </Row>
        </Container>
    </ParallaxStyled>
  );
};

export default Jumbotron;