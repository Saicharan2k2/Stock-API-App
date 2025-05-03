import React from 'react';

const Footer = () => {
  return (
    <footer style={{
      background: 'linear-gradient(to right, rgb(252, 99, 3), rgba(0, 0, 0))',
      color: '#fff',
      padding: '1rem',
      textAlign: 'center',
      fontFamily: 'cursive',
    }}>
      <p> Stock Price App &copy; {new Date().getFullYear()} | Built with ❤️ using React & Spring Boot</p>
    </footer>
  );
};

export default Footer;