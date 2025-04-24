import React from 'react';
import { Container,Row,Col } from 'react-bootstrap';
import { Parallax } from 'react-parallax';
import img from '../assets/bg_jumbotron.jpg'
const Jumbotron = () => {
  return (
    <Parallax bgImage={img} strength={200}>
        <Container className='my-5 pt-5'>
        <Row>
            <Col className="text-center text-light">
              <h3>why choose us</h3>
              <br />
              <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
              </p>
            </Col>
          </Row>
          <Row className='text-center text-light my-5 pb-5'>
            <Col>
              <h1>2300</h1>
              <p>invesment planning</p>
            </Col>
            <Col>
              <h1>3250</h1>
              <p>commodities trading</p>
            </Col>
            <Col>
              <h1>4571</h1>
              <p>wealth management</p>
            </Col>
            <Col>
              <h1>5475</h1>
              <p>happy clients</p>
            </Col>
          </Row>
        </Container>
    </Parallax>
  );
};

export default Jumbotron;