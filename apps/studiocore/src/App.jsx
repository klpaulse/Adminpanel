import { useState, useEffect } from 'react'

function App() {
    const [melding, setMelding] = useState('Laster...')

  useEffect(() => {
    fetch(`${import.meta.env.VITE_API_URL}/api/test`)
      .then(res => res.text())
      .then(data => setMelding(data))
      .catch(() => setMelding('Feil: backend ikke tilgjengelig'))
  }, [])

    return <h1>{melding}</h1>
}

export default App
