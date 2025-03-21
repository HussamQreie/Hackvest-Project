const canvas = document.createElement("canvas");
document.body.appendChild(canvas);
const ctx = canvas.getContext("2d");
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;
const chars = "HACKFEST2025";
let drops = Array(Math.floor(canvas.width / 20)).fill(1);
setInterval(() => {
    ctx.fillStyle = "rgba(0, 0, 0, 0.05)";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    ctx.fillStyle = "#0f0";
    drops.forEach((y, i) => {
        ctx.fillText(chars[Math.floor(Math.random() * chars.length)], i * 20, y * 20);
        drops[i] = y > canvas.height / 20 || Math.random() > 0.95 ? 0 : y + 1;
    });
}, 50);