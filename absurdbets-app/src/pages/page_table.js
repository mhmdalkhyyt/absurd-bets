import React, { useState, useEffect } from 'react';

const PageTable = () => {
    const [bets, setBets] = useState([]);

    useEffect(() => {
        // Fetch data from the backend when the component mounts
        fetch('jdbc:mysql://localhost:3306/absurdbetstest_db') // Replace with your actual API endpoint
            .then(response => response.json())
            .then(data => setBets(data))
            .catch(error => console.error('Error fetching data:', error));
    }, []); // Empty dependency array ensures the effect runs once after the initial render

    return (
        <div>
            <h1>Bets Table</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>User ID</th>
                        <th>Bet amount</th>
                        {/* Add more table headers based on your database schema */}
                    </tr>
                </thead>
                <tbody>
                    {bets.map(bet => (
                        <tr key={bet.id}>
                            <td>{bet.id}</td>
                            <td>{bet.user_id}</td>
                            <td>{bet.bet_amount}</td>
                            {/* Add more table cells based on your database schema */}
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default PageTable;