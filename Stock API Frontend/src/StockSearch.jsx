import React, { useState } from 'react';
import axios from 'axios';
import { Line } from 'react-chartjs-2';
import ClipLoader from 'react-spinners/ClipLoader';
import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend
} from 'chart.js';

ChartJS.register(LineElement, CategoryScale, LinearScale, PointElement, Tooltip, Legend);

const StockSearch = () => {
  const [symbol, setSymbol] = useState('');
  const [data, setData] = useState(null);
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const fetchStockData = async () => {
    setLoading(true);
    try {
      const res = await axios.get(`http://localhost:1234/api/stocks/${symbol}`);
      setData(res.data);
      setError('');
      await axios.post('http://localhost:8082/api/history/save', {
        symbol: res.data.symbol,
        name: res.data.name,
        open: res.data.open,
        high: res.data.high,
        low: res.data.low,
        price: res.data.price,
        previousClose: res.data.previousClose,
        volume: res.data.volume
      });
    } catch (err) {
      console.error(err);
      setError('Stock not found !!');
      setData(null);
    } finally {
      setLoading(false);
    }
  };

  const chartData = {
    labels: ['Open', 'High', 'Low', 'Close'],
    datasets: [
      {
        label: `${data?.companyName} (${data?.symbol})`,
        data: [data?.open, data?.high, data?.low, data?.price],
        fill: false,
        borderColor: '#fff',
        backgroundColor: '#0000FF',
        tension: 0.4,
      }
    ]
  };

  const chartOptions = {
    responsive: true,
    plugins: {
      legend: {
        labels: {
          color: 'white'
        }
      }
    },
    scales: {
      x: { ticks: { color: 'white' } },
      y: { ticks: { color: 'white' } }
    }
  };

  return (
    <div style={{
      background: 'linear-gradient(to right, rgb(252, 99, 3), rgba(0, 0, 0))',
      minHeight: '100vh',
      padding: '2rem',
      color: '#fff',
      fontFamily: 'cursive'
    }}>
      <h1 style={{ textAlign: 'center' }}>📈 Stock Price Search</h1>

      <div style={{ display: 'flex', justifyContent: 'center', marginBottom: '2rem' }}>
        <input
          type="text"
          value={symbol}
          onChange={(e) => setSymbol(e.target.value)}
          placeholder="Enter Stock Symbol (e.g. AAPL)"
          style={{
            padding: '0.5rem 1rem',
            fontSize: '1rem',
            fontFamily: 'cursive',
            borderRadius: '10px',
            border: 'none',
            width: '300px',
            marginRight: '10px'
          }}
        />
        <button
          onClick={fetchStockData}
          style={{
            padding: '0.5rem 1.5rem',
            fontSize: '1rem',
            borderRadius: '10px',
            backgroundColor: '#73B54A',
            fontFamily: 'cursive',
            color: '#fff',
            border: 'none',
            cursor: 'pointer'
          }}
        >
          Search
        </button>
      </div>

      {loading && (
        <div style={{ textAlign: 'center', marginBottom: '1rem' }}>
          <ClipLoader color="#fff" size={50} />
          <p style={{ fontSize: '1.2rem', marginTop: '0.5rem' }}>Fetching stock data...</p>
        </div>
      )}

      {error && (
        <div style={{
          padding: '10px',
          fontSize: '1.5rem',
          textAlign: 'center',
          marginTop: '1rem'
        }}>
          {error}
        </div>
      )}

      {data && !loading && (
        <div style={{
          backgroundColor: '#ffffff33',
          padding: '2rem',
          borderRadius: '15px',
          fontFamily: 'cursive',
          width: '600px',
          margin: '0 auto',
          textAlign: 'center'
        }}>
          <h3>{data.companyName} ({data.symbol})</h3>
          <p><strong>Price:</strong> ${data.price}</p>
          <p><strong>Open:</strong> ${data.open}</p>
          <p><strong>High:</strong> ${data.high}</p>
          <p><strong>Low:</strong> ${data.low}</p>
          <p><strong>Volume:</strong> {data.volume}</p>
          <p><strong>Previous Close:</strong> ${data.previousClose}</p>
          <div style={{ marginTop: '2rem' }}>
            <Line data={chartData} options={chartOptions} />
          </div>
        </div>
      )}
    </div>
  );
};

export default StockSearch;