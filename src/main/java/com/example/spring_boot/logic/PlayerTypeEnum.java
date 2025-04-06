package com.example.spring_boot.logic;

public enum PlayerTypeEnum {

  OFFENSIVE {
    public String toString() {
      return "Offensive";
    }
  },

  DEFENSIVE {
    public String toString() {
      return "Defensive";
    }
  },

  BALANCED {
    public String toString() {
      return "Balanced";
    }
  },

  LOCATION {
    public String toString() {
      return "Location";
    }
  },
}
