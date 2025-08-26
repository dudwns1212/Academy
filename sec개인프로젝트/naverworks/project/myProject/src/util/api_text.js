import axios from "axios";

export const apiText = axios.create({
  baseURL: 'http://localhost:8001/text/v1',
  timeout: 5000, // 5 seconds
  headers: {
      'Content-Type': 'application/json',
  }
})