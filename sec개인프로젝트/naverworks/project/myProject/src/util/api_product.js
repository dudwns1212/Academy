import axios from "axios";

export const apiProduct = axios.create({
  baseURL: 'http://172.168.10.102:8001/product/v1',
  timeout: 5000, // 5 seconds
  headers: {
      'Content-Type': 'application/json',
  }
})