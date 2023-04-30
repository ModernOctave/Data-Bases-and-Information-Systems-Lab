import { useCP } from '../../hooks/CPContext';
import { Button } from 'react-bootstrap';
const ical = require('ical-generator')

export default function DownloadButton() {
	const CP = useCP()

	function getPreviousWeekDate(date) {
		date = new Date(date)
		return new Date(date.getFullYear(), date.getMonth(), date.getDate() - 7, date.getHours(), date.getMinutes());
    }

	function handleDownload() {
		const calendar = ical({name: 'Calendar'});
		CP.schedules.map(myClass => {
			calendar.createEvent({
				start: new Date(getPreviousWeekDate(myClass.start)),
				end: new Date(getPreviousWeekDate(myClass.end)),
				summary: myClass.title,
				repeating: { freq: 'WEEKLY', count: 13 }
			})
		})
		console.log(calendar.toString())
	}
	return (
		<Button variant="outline-dark" className="my-2" onClick={handleDownload}>Download</Button>
	)
}