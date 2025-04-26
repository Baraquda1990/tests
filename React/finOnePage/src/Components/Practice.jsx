import { Container,Row,Col,Card } from 'react-bootstrap'
import portfolio_1 from '../assets/portfolio1.jpg'
import portfolio_2 from '../assets/portfolio2.jpg'
import portfolio_3 from '../assets/portfolio3.jpg'
import portfolio_4 from '../assets/portfolio4.jpg'
import '../assets/font/font.css'
import styled from 'styled-components'
const PracticeWrapper=styled.section`
  font-family:'OpenSansBold';
  .slogan{
    font-weight:bold;
    color:#4a657d;
  }
  .text{
    color:#4a657d;
  }
  .card{
    
  }
  .card-title{
    color:#1f87e4;
  }
  .card-text{
    color:#4a657d;
  }
`
export default function Practice(){
return (<PracticeWrapper id="services"><Container className='my-5'>
          <Row>
            <Col className="text-center">
              <h3 className='slogan'>{'наши услуги'.toUpperCase()}</h3>
              <br />
              <p className='text'>
                Предлагаем широкий перечень консалтинговых услуг для микро, малого и среднего бизнеса Казахстана.
              </p>
              <br/>
            </Col>
          </Row>
          <Row>
            <Col md={3} sm={6}>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_1} />
              <Card.Body>
                <Card.Title>{'разработка бизнес - планов'.toUpperCase()}</Card.Title>
                <Card.Text>
                  Разрабатываем индивидуальные бизнес - планы для малого и среднего бизнеса.
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
            <Col md={3} sm={6}>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_2} />
              <Card.Body>
                <Card.Title>{'курсы финансового анализа'.toUpperCase()}</Card.Title>
                <Card.Text>
                  Обучаем финансовому анализу на индивидуальных онлайн - курсах.
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
            <Col md={3} sm={6}>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_3} />
              <Card.Body>
                <Card.Title>{'маркетинговые исследования'.toUpperCase()}</Card.Title>
                <Card.Text>
                  Проводим анализ рынка отрасли товаров и услуг. 
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
            <Col md={3} sm={6}>
              <Card style={{border:'none'}}>
              <Card.Img variant="top" src={portfolio_4} />
              <Card.Body>
                <Card.Title>{'Услуги кредитного блоккера'.toUpperCase()}</Card.Title>
                <Card.Text>
                   Предоставляем услуги оформления кредитов для бизнеса.
                </Card.Text>
              </Card.Body>
            </Card>
            </Col>
          </Row>
        </Container></PracticeWrapper>)}