import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav style={{
      background: 'linear-gradient(to right,rgb(0, 0, 0),rgb(0,0,0))',
      padding: '1rem',
      display: 'flex',
      justifyContent: 'space-around',
      alignItems: 'center',
    }}>
      <Link
        to="/"
        style={{
          color: '#fff',
          textDecoration: 'none',
          fontSize: '1.2rem',
          transition: 'color 0.3s ease',
          fontFamily:'cursive'
        }}
        onMouseEnter={(e) => e.target.style.color = '#ffb74d'}
        onMouseLeave={(e) => e.target.style.color = '#fff'}
      >
        Stock Search
      </Link>
      <Link
        to="/history"
        style={{
          color: '#fff',
          textDecoration: 'none',
          fontSize: '1.2rem',
          transition: 'color 0.3s ease',
          fontFamily:'cursive'
        }}
        onMouseEnter={(e) => e.target.style.color = '#ffb74d'}
        onMouseLeave={(e) => e.target.style.color = '#fff'}
      >
        View History
      </Link>
    </nav>
  );
};

export default Navbar;