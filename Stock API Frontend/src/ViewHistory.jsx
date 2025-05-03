import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ViewHistory = () => {
  const [history, setHistory] = useState([]);
  const [error, setError] = useState('');
  useEffect(() => {
    fetchHistory();
  }, []);

  const fetchHistory = async () => {
    try {
      const res = await axios.get('http://localhost:8082/api/history/all');
      setHistory(res.data);
      setError('');
    } catch (error) {
      console.error('Error fetching stock history !!', error);
      setError('Error fetching stock history !!', error);
    }
  };

  const styles = {
    th: {
      padding: '12px 15px',
      border: '1px solid #ccc',
      textAlign: 'center',
    },
    td: {
      padding: '12px 15px',
      border: '1px solid #ccc',
      textAlign: 'center',
      fontWeight: '500',
    },
  };

  return (
    <div style={{
      background: 'linear-gradient(to right, rgb(252, 99, 3), rgba(0, 0, 0))',
      minHeight: '100vh',
      padding: '2rem',
      fontFamily: 'cursive'
    }}>
      <h2 style={{ color: '#fff', textAlign: 'center', fontSize: '2rem' }}>
        Searched Stocks History
      </h2>

      <div style={{ overflowX: 'auto', marginTop: '2rem' }}>
        <table style={{
          width: '100%',
          borderCollapse: 'collapse',
          backgroundColor: '#fff',
          borderRadius: '10px',
          boxShadow: '0 0 15px rgba(0, 0, 0, 0.2)',
          overflow: 'hidden',
        }}>
          <thead>
            <tr style={{ color: '#000' }}>
              <th style={styles.th}>Symbol</th>
              <th style={styles.th}>Open</th>
              <th style={styles.th}>High</th>
              <th style={styles.th}>Low</th>
              <th style={styles.th}>Price</th>
              <th style={styles.th}>Previous Close</th>
              <th style={styles.th}>Volume</th>
            </tr>
          </thead>
          <tbody>
            {history.map((stock, index) => (
              <tr key={index} style={{ borderBottom: '1px solid #ddd' }}>
                <td style={styles.td}>{stock.symbol}</td>
                <td style={styles.td}>{stock.open}</td>
                <td style={styles.td}>{stock.high}</td>
                <td style={styles.td}>{stock.low}</td>
                <td style={styles.td}>{stock.price}</td>
                <td style={styles.td}>{stock.previousClose}</td>
                <td style={styles.td}>{stock.volume}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {error && (
        <div style={{
          color: '#fff',
          padding: '10px',
          fontSize: '1.5rem',
          textAlign: 'center',
          marginTop: '1rem'
        }}>
          {error}
        </div>
      )}
    </div>
  );
};

export default ViewHistory;