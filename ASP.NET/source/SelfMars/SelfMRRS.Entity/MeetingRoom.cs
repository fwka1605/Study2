using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SelfMRRS.Entity
{
    public class MeetingRoom
    {
        public int MeetingRoomId { get; set; }
        public string MeetingRoomName { get; set; }
        public int LocationId { get; set; }

        public virtual Location Location { get; set; } 
        public virtual ICollection<Reservation> Reservations { get; set; }
    }
}
