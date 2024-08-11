import  React, { useState } from 'react';
import { useAuthContext } from '../context/AuthContext';

export function MainLogin() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const {login} = useAuthContext();


  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    
    console.log(`User: ${username}, Password: ${password}`);
    await login(username, password);
  }
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
    <div className="bg-white p-8 rounded shadow-lg w-[90%] max-w-md">
      <h2 className="text-2xl font-bold mb-6 text-gray-800">Iniciar sesion</h2>
      <form onSubmit={handleLogin}>
        <div className="mb-4">
          <label htmlFor="username" className="block text-sm font-medium text-gray-700">
            Usuario
          </label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            className="mt-1 px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 w-full"
            required
          />
        </div>
        <div className="mb-6">
          <label htmlFor="password" className="block text-sm font-medium text-gray-700">
            Password
          </label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="mt-1 px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 w-full"
            required
          />
        </div>
        <button
          type="submit"
          className="w-full bg-indigo-500 text-white py-2 px-4 rounded-md hover:bg-indigo-600 transition duration-200"
        >
          Login
        </button>
      </form>
    </div>
  </div>
  );
}
