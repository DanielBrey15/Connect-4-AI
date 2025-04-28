import React from 'react';

type DropdownProps = {
    options: string[];
    value: string;
    onChange: (value: string) => void;
  };
  
export const Dropdown: React.FC<DropdownProps> = ({ options, value, onChange }) => {
    return (
        <div>
            <p>Options: {options.join(", ")}</p>
            <input
                type="text"
                value={value}
                onChange={(e) => onChange(e.target.value)}
            />
        </div>
    );
};
