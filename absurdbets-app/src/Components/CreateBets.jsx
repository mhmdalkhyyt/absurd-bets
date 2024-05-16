import React, { useState } from 'react';
import axios from 'axios';

function CreateBets() {
    const [betId, setBetId] = useState(''); // Initialize state for bet id
    const [userId, setUserId] = useState(''); // Initialize state for user id
    const [betAmount, setBetAmount] = useState(''); // Initialize state for bet amount

    const createBet = () => {
        axios.post('/api/createBet', { bet_id: betId, user_id: userId, bet_amount: betAmount }) // Send bet data to server
            .then(response => {
                console.log(response);
                setBetId(''); // Clear input field after successful request
                setUserId(''); // Clear input field after successful request
                setBetAmount(''); // Clear input field after successful request
            })
            .catch(error => {
                console.log(error);
            });
    };

    return (
        <div>
            <input
                type="text"
                value={betId}
                onChange={e => setBetId(e.target.value)} // Update bet id when input changes
                placeholder="Enter your bet id"
            />
            <input
                type="text"
                value={userId}
                onChange={e => setUserId(e.target.value)} // Update user id when input changes
                placeholder="Enter your user id"
            />
            <input
                type="text"
                value={betAmount}
                onChange={e => setBetAmount(e.target.value)} // Update bet amount when input changes
                placeholder="Enter your bet amount"
            />
            <button onClick={createBet}>Create Bet</button>
        </div>
    );
}

export default CreateBets;
