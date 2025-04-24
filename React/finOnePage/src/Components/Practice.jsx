import { Container,Row,Col,Card } from 'react-bootstrap'

import portfolio_1 from '../assets/portfolio1.jpg'
import portfolio_2 from '../assets/portfolio2.jpg'
import portfolio_3 from '../assets/portfolio3.jpg'
import portfolio_4 from '../assets/portfolio4.jpg'

export default function Practice(){
return (<Container className='my-5'>
          <Row>
            <Col className="text-center">
              <h3>Our practice areas</h3>
              <br />
              <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
              </p>
            </Col>
          </Row>
          <Row>
            <Col>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_1} />
              <Card.Body>
                <Card.Title>analytics service</Card.Title>
                <Card.Text>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
            <Col>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_2} />
              <Card.Body>
                <Card.Title>business service</Card.Title>
                <Card.Text>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
            <Col>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_3} />
              <Card.Body>
                <Card.Title>finance service</Card.Title>
                <Card.Text>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
            <Col>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_4} />
              <Card.Body>
                <Card.Title>transport & logistics</Card.Title>
                <Card.Text>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
          </Row>
        </Container>)}