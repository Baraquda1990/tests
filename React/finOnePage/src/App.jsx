import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import {Button, Container,Row,Col,Nav,Navbar,Carousel,Card,CardGroup} from 'react-bootstrap'
import slide from './assets/home.jpg'
import leftImg from './assets/left_img.jpg'
import portfolio_1 from './assets/portfolio1.jpg'
import portfolio_2 from './assets/portfolio2.jpg'
import portfolio_3 from './assets/portfolio3.jpg'
import portfolio_4 from './assets/portfolio4.jpg'
import Jumbotron from './Components/Jumbotron.jsx'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Container fluid className='bg-primary'>
        <Row className='pb-3 pt-3 align-items-center'>
          <Col md={2}>Call Us 1-587-659-478</Col>
          <Col md={3}>Mail: examples@company.com</Col>
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
        
        <Carousel data-bs-theme="dark">
        <Carousel.Item>
          <img
            className="d-block w-100"
            src={slide}
            alt="First slide"
          />
          <Carousel.Caption>
            <h5>{'training company make your dream'.toUpperCase()}</h5>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src={slide}
            alt="Second slide"
          />
          <Carousel.Caption>
            <h5>Second slide label</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src={slide}
            alt="Third slide"
          />
          <Carousel.Caption>
            <h5>Third slide label</h5>
            <p>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>

      <Container fluid className='my-5'>
        <Row className='align-items-center'>
          <Col className='md-3 ps-0'><img src={leftImg} alt="" /></Col>
          <Col md={7}>
            {'we are consulting company help you in start'.toUpperCase()}
            <br/>
            <p>
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
            <Button className='btn-primary'>Our company</Button>
          </Col>
        </Row>
        </Container>
        
        <Container>
          <Row>
            <Col className="text-center">
              <h3>OUR CONSULTING SERVICES</h3>
              <br />
              <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
              </p>
            </Col>
          </Row>
        <Row>
          <Col className='text-center mb-5 mt-5'>
            <img className='mb-3' src="" alt="" />
            <h3 className='mb-3'>Business planning, strategy &
            Execution</h3>
            <p className='mb-3'>Lorem ipsum dolor sit amet, consectetur 
            adipisicing elit, sed doadiadipisicing
            elit, sed do pisicing elit, sed do</p>
            <Button className='mb-3'>read more</Button>
          </Col>
          <Col className='text-center mb-5 mt-5'>
            <img className='mb-3' src="" alt="" />
            <h3 className='mb-3'>financy projections and
            analysis</h3>
            <p className='mb-3'>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
            <Button>read more</Button>
          </Col>
          <Col className='text-center mb-5 mt-5'>
            <img className='mb-3' src="" alt="" />
            <h3 className='mb-3'>international business
            opportunitis</h3>
            <p className='mb-3'>Lorem ipsum dolor sit amet, consectetur 
            adipisicing elit, sed doadiadipisicing
            elit, sed do pisicing elit, sed do</p>
            <Button>read more</Button>
          </Col>
        </Row>
        </Container>

        <Container className='my-5'>
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
        </Container>

        <Jumbotron></Jumbotron>

        <Container className="my-5">
          <Row>
            <Col className="text-center">
              <h3>our portfolio</h3>
              <br />
              <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua
              </p>
            </Col>
          </Row>
        </Container>

        <Container fluid className='pt-5 pb-2 bg-primary'>
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
        </Container>
    </>
  )
}

export default App
