import { Button, Container, Nav, Navbar as NavbarBs } from "react-bootstrap"
import { NavLink } from "react-router-dom"

export function NavbarApp() {
  return (
    <NavbarBs sticky="top" className="bg-white shadow-sm mb-3">
      <Container>
        <Nav className="me-auto">
          <Nav.Link to="/" as={NavLink}>
            Home
          </Nav.Link>
          <Nav.Link to="/signIn" as={NavLink}>
            Login
          </Nav.Link>
          <Nav.Link to="/signUp" as={NavLink}>
            Register
          </Nav.Link>
          <Nav.Link to="/" as={NavLink}>
            Admin Login
          </Nav.Link>
        </Nav>
      </Container>
    </NavbarBs>
  )
}