import logo from './logo.svg';
import './App.css';

import React, { useState, useEffect  } from 'react';
import { BrowserRouter as Router, Route, Switch, Link } from './';
import HomePage from './App.js';
import PageTable from './pages/page_table';
import BurgerMenu from './Components/functions';

const LandingPage = () => {
  return (
    <div className="landing-page">
      <header className="header">
        <h1>Welcome to Absurd Bets</h1>
        <p>create or bet on the most absurd bets</p>
      </header>
      <section className="features">
       
      <footer className="footer">
        <p>&copy; 2023 Your Company</p>
      </footer>


        <div>
          <div>
            <ConnectionStatus/>
          </div>
        <GetBet/>
        </div>
      
      </section>

  
    </div>
  );
};


const GetBet = () => {
  const bettingHeader = "Betting Game";
  const bettingDescription = "Place your bet and choose your option.";

  return (
    <div className="App">
      <BettingCard header={bettingHeader} description={bettingDescription} />
    </div>
  );
};


const BettingCard = ({ header, description }) => {
  return (
    <div className='betting-card'>
      <h2>{header}</h2>
      <p>{description}</p>
      <ButtonComponent />
      <RedirectButton/>
    </div>
  );
};




const ButtonComponent = () => {
  const [selectedChoice, setSelectedChoice] = useState(null);
  //const []

  const handleButtonClick = (choice) => {
    setSelectedChoice(choice);
  };

  return (
    <div>
      <h1>Choose a Button</h1>
      <button className='bet-choice-button' onClick={() => handleButtonClick('A')}>Choice A</button>
      <button className='bet-choice-button' onClick={() => handleButtonClick('B')}>Choice B</button>

      {selectedChoice && <p>You chose: {selectedChoice}</p>}
    </div>
  );
};



const ConnectionStatus = () => {
  const [status, setStatus] = useState('');

  useEffect(() => {
    // Fetch connection status from the backend when the component mounts
    fetch('/api/bets') // Replace with your actual API endpoint
      .then(response => response.json())
      .then(data => setStatus(data.status))
      .catch(error => {
        console.error('Error fetching connection status:', error);
        setStatus('Error: Unable to fetch connection status');
      });
  }, []); // Empty dependency array ensures the effect runs once after the initial render

  return (
    <div>
      <h2>Connection status: {status}</h2>
    </div>
  );
};

const RedirectButton = () => {
  const history = useHistory();

  const redirectToPageTable = () => {
    history.push('/pages/page_Table');
  };

  return (
    <div>
      <h1>Welcome to My App</h1>
      <button onClick={redirectToPageTable}>Go to Page Table</button>
    </div>
  );
};

export default LandingPage;



