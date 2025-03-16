import React, { useState } from 'react';

const Stock = () => {
    const [price, setPrice] = useState(null);
    const [symbol, setSymbol] = useState('');
    const [error, setError] = useState(null);

    const fetchStockPrice = async () => {
        try {
            const response = await fetch(`http://localhost:8080/stocks/${symbol}`);
            if (!response.ok) {
                throw new Error('Failed to fetch stock price');
            }
            const data = await response.json();
            setPrice(data);
            setError(null);

            await fetch('http://localhost:8080/history', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ symbol, price: data }),
            });
        } catch (err) {
            setError(err.message);
            setPrice(null);
        }
    };

    return (
        <div className="container mt-5">
            <h1>Stock Lookup</h1>
            <div className="mb-3">
                <input
                    type="text"
                    placeholder="Enter stock symbol (e.g., AAPL)"
                    value={symbol}
                    onChange={(e) => setSymbol(e.target.value)}
                    className="form-control"
                />
                <button onClick={fetchStockPrice} className="btn btn-primary mt-2">Search</button>
            </div>
            {error && <div className="alert alert-danger">{error}</div>}
            {price !== null && (
                <div className="mt-3">
                    <h2>{symbol}</h2>
                    <p>Price: ${price.toFixed(2)}</p>
                </div>
            )}
        </div>
    );
};

export default Stock;