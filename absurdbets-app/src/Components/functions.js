import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const BurgerMenu = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className={`burger-menu ${isOpen ? 'open' : ''}`}>
      <div className="menu-toggle" onClick={toggleMenu}>
        ☰
      </div>
      <div className="menu-options">
        <Link to="/">Home</Link>
        <Link to="/page-table">Page Table</Link>
      </div>
    </div>
  );
};

export default BurgerMenu;