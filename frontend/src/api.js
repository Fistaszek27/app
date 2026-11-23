import express from 'express';
import cors from 'cors';

const app = express();
app.use(cors());


app.get('/api/v1/health', (req, res) => {
    res.status(200).json({ status: "ok" });
});


app.listen(5000, () => {
    console.log("Zamek działa i CZEKA cały czas na http://localhost:5000");
});
