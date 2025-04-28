import React, {useState} from 'react';
import {Dropdown} from "./Dropdown";
 
export const Page = () => {
    const [p1Type, setp1Type] = useState("");
    const [p1Layers, setp1Layers] = useState("");
    const [p2Type, setp2Type] = useState("");
    const [p2Layers, setp2Layers] = useState("");
    const [game, setGame] = useState("");

    const handleButtonClick = () => {
        fetch('/api/runGame')
          .then(response => response.text())
          .then(data => setGame(data))
          .catch(error => console.error('Error fetching data:', error));
      };

    return (
        <div>
            <Dropdown
                options={["Offensive", "Defensive"]}
                value={p1Type}
                onChange={val => setp1Type(val)}
            />
            <Dropdown
                options={["1", "2", "3", "4", "5"]}
                value={p1Layers}
                onChange={val => setp1Layers(val)}
            />
            <Dropdown
                options={["Offensive", "Defensive"]}
                value={p2Type}
                onChange={val => setp2Type(val)}
            />
            <Dropdown
                options={["1", "2", "3", "4", "5"]}
                value={p2Layers}
                onChange={val => setp2Layers(val)}
            />
            <button onClick={handleButtonClick}>Go to Google</button>
            <div dangerouslySetInnerHTML={{ __html: game }} />
        </div>
    )
}