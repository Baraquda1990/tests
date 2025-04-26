import { Carousel } from "react-bootstrap"
import slide from '../assets/home.jpg'
import styled from "styled-components"

const StyledCarousel=styled(Carousel)`
  .carousel-indicators{
    button{width:20px;
      height:20px;
      border-radius:50%;
      background-color:#1f87e4 !important;
    }
  }
  h5{
    color:#4a657d;
    font-weight: bold;
  }
`

export default function Slider(){
return(
<StyledCarousel data-bs-theme="dark">
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
    <h5>{'training company make your dream'.toUpperCase()}</h5>
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
    <h5>{'training company make your dream'.toUpperCase()}</h5>
    <p>
      Praesent commodo cursus magna, vel scelerisque nisl consectetur.
    </p>
  </Carousel.Caption>
</Carousel.Item>
</StyledCarousel>)}