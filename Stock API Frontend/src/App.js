import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StockSearch from './StockSearch';
import ViewHistory from './ViewHistory';
import Navbar from './Navbar';
import Footer from './Footer';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<StockSearch />} />
        <Route path="/history" element={<ViewHistory />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
