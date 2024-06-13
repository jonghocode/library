import React, { useState, useEffect } from 'react';
import { seetList, seetAdd } from "./api";
import './Main.css';

function Main() {
    const [seet, setSeet] = useState([]);
    const [selectedSeet, setSelectedSeet] = useState(null);
    const [time, setTime] = useState('');

    useEffect(() => {
        seetList(setSeet);
    }, []);

    const handleBoxClick = (item) => {
        setSelectedSeet(item);
        setTime(item.time);
    };

    const handleCloseModal = () => {
        setSelectedSeet(null);
        setTime('');
    };

    const handleSaveTime = () => {
        const updatedSeet = seet.map((item) =>
            item.id === selectedSeet.id ? { ...item, time } : item
        );
        setSeet(updatedSeet);
        handleCloseModal();
    };

    return (
        <>
            <div className="grid-container">
                {seet.map((item) => (
                    <div
                        key={item.id}
                        className="box"
                        style={{ backgroundColor: item.memberId ? 'gray' : 'green' }}
                        onClick={() => handleBoxClick(item)}
                    >
                        <p>ID: {item.id}</p>
                    </div>
                ))}
            </div>
            {selectedSeet && (
                <div className="modal">
                    <div className="modal-content">
                        <span className="close" onClick={handleCloseModal}>&times;</span>
                        <h2>예약 시간</h2>
                        <h5>예약한 시간부터 2시간 입니다.</h5>
                        <input
                            type="time"
                            value={time}
                            onChange={(e) => setTime(e.target.value)}
                        />
                        <button onClick={handleSaveTime}>예약</button>
                    </div>
                </div>
            )}
        </>
    );
}

export default Main;
