import { Container,Row,Col,Button } from "react-bootstrap"
export default function Services(){        
        return(<Container>
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
        </Container>)}