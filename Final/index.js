const express = require('express');

const app = express()
app.use(express.json());

app.listen(3000, () => {
    console.log(`Server listening on port 3000`);
})

app.get('', (req, resp) => {
    var name = req.query.name;
    console.log(name);
    if (name) {
        resp.end('Welcome ' + name + '\n');
    } else {
        resp.end("Hello World\n");
    }
})

app.get('/user', (req, resp) => {
    const user = {
        "userName": "Mengyi",
    };
    const data = JSON.stringify(user)
    resp.send(data);
})